class EstablecimientosController < ApplicationController
  before_action :set_establecimiento, only: [:show, :edit, :update, :destroy]


  def agregar_comentario
    @establecimiento = Establecimiento.find(params[:id])
    @establecimiento.EstComentarios.create(:descripcion => params[:comentario], :usuario_id => current_usuario.id)
    redirect_to @establecimiento
  end

  # GET /establecimientos/1/comentarios.json
  def comentarios
      if (params[:appkey].eql? appkey)  #si el appkey es correcto
        @establecimiento = Establecimiento.find(params[:id])
        comentarios = @establecimiento.EstComentarios
        coms=comentarios.map { |comentario| { :nombre_usuario => comentario.usuario.nombre, :contenido => comentario.descripcion }}
        render json: coms
      else
               render json: {:error => "No autorizado"}
      end
  end

  # GET /establecimientos
  # GET /establecimientos.json
  def index
    @establecimientos = Establecimiento.all
    respond_to do |format|
      format.json {  

                    if (params[:appkey].eql? appkey)  #si el appkey es correcto

                      ests = @establecimientos.map { |establecimiento| { :nombre_establecimiento => establecimiento.nombre, :id => establecimiento.id, 
                                                            :descripcion => establecimiento.descripcion, :longitud => establecimiento.longitud,
                                                            :latitud => establecimiento.latitud, :direccion => establecimiento.direccion, :imagen => establecimiento.foto.url(:small),
                                                            :eventos => establecimiento.eventos.map { |evento| { :nombre => evento.nombre } }      } } 
                      render json: ests
                    else
                             render json: {:error => "No autorizado"}
                    end



                      }
      format.html { redirect_to :controller=>'login', :action=>'login' } #solo el app movil puede revisar toda la lista de establecimientos.
    end
  end

  # GET /establecimientos/1
  # GET /establecimientos/1.json
  def show 
    est = @establecimiento
    respond_to do |format|
      format.html
      format.json { 

                  if (params[:appkey].eql? appkey)  #si el appkey es correcto
                    render :json => {:nombre => @establecimiento.nombre, direccion: @establecimiento.direccion, :latitud => @establecimiento.latitud,
                                     :longitud => @establecimiento.longitud, :descripcion => @establecimiento.descripcion, :imagen => @establecimiento.foto.url(:small),
                                     :comentarios => @establecimiento.EstComentarios.map { |comentario| { :descripcion => comentario.descripcion, :usuario => comentario.usuario.nombre } } }   

                    else
                             render json: {:error => "No autorizado"}
                    end


                                 }
      end
      #No tiene restricciones, queda abierto para el API
  end

  # GET /establecimientos/new
  def new
    if (usuario_signed_in?) #Si hay un usuario logueado, entonces lo toma
      @usuario = current_usuario
      @establecimiento = Establecimiento.new
    else #Si no hay usuario logueado, entonces no lo deja crear establecimiento y lo manda a loguearse.
      redirect_to :controller=>'login', :action=>'login'
    end
  end

  # GET /establecimientos/1/edit
  def edit
      @usuario = Establecimiento.find(params[:id]).usuario #busca el usuario al que pertenece el establecimiento
      if (current_usuario != @usuario) #si el usuario logueado no es el mismo
        redirect_to :controller=>'login', :action=>'login' #lo envia a login, no lo deja modificarlo
      end
      #si llega aca es porque si es el dueño del establecimiento
  end

  # POST /establecimientos
  # POST /establecimientos.json
  def create
    if (usuario_signed_in? != true) #Si no hay usuario logueado
        redirect_to :controller=>'login', :action=>'login' #lo envia a login
    end
    @establecimiento = Establecimiento.new(establecimiento_params)
    @establecimiento.usuario_id = current_usuario.id
    respond_to do |format|
      if @establecimiento.save
        format.html { redirect_to current_usuario, notice: 'Establecimiento was successfully created.' }
        format.json { render action: 'show', status: :created, location: @establecimiento }
      else
        format.html { render action: 'new' }
        format.json { render json: @establecimiento.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /establecimientos/1
  # PATCH/PUT /establecimientos/1.json
  def update
      @usuario = Establecimiento.find(params[:id]).usuario #busca el usuario al que pertenece el establecimiento
      if (current_usuario != @usuario) #si el usuario logueado no es el mismo
        redirect_to :controller=>'login', :action=>'login' #lo envia a login, no lo deja modificarlo
      end
      #si llega aca es porque si es el dueño del establecimiento
    respond_to do |format|
      if @establecimiento.update(establecimiento_params)
        format.html { redirect_to current_usuario, notice: 'Establecimiento was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: 'edit' }
        format.json { render json: @establecimiento.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /establecimientos/1
  # DELETE /establecimientos/1.json
  def destroy
      @usuario = Establecimiento.find(params[:id]).usuario #busca el usuario al que pertenece el establecimiento
      if (current_usuario != @usuario) #si el usuario logueado no es el mismo
        redirect_to :controller=>'login', :action=>'login' #lo envia a login, no lo deja modificarlo
      end
    @establecimiento.destroy
    respond_to do |format|
      format.html { redirect_to current_usuario }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_establecimiento
      @establecimiento = Establecimiento.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def establecimiento_params
      params.require(:establecimiento).permit(:nombre, :direccion, :longitud, :latitud, :descripcion, :usuario_id, :foto)
    end
end

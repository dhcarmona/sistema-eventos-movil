class EventosController < ApplicationController
  before_action :set_evento, only: [:show, :edit, :update, :destroy]
  helper :all

  # GET /eventos
  # GET /eventos.json
  def index
    @eventos = Evento.all
    respond_to do |format|
      format.json { 
                  if (params[:appkey].eql? appkey)  #si el appkey es correcto
                    evs = @eventos.map { |evento| { :nombre_evento => evento.nombre, :id => evento.id, 
                                                          :descripcion => evento.descripcion, :establecimiento_nombre => evento.establecimiento.nombre,
                                                      :establecimiento_id => evento.establecimiento.id, :tipos => evento.tipos.map {|tipo| {:nombre => tipo.nombre } } } }

                    render json: evs 
                  else
                    render json: {:error => "No autorizado"}
                  end
                  }
      format.html { redirect_to :controller=>'login', :action=>'login' } #solo el app movil puede revisar toda la lista de eventos.
    end
  end

  #GET /eventos/1/nuevo_horario
  # esta accion renderiza el view para poder agregar un nuevo horario al evento
  def nuevo_horario
    @usuario = Evento.find(params[:id]).establecimiento.usuario #busca el usuario al que pertenece el evento
    if (current_usuario != @usuario) #si el usuario logueado no es el mismo
        redirect_to :controller=>'login', :action=>'login' #lo envia a login, no lo deja modificarlo
      end
    #si llega aca, es el dueño del evento
    @evento = Evento.find(params[:id]) #obtener el evento
  end

  # POST /eventos/1/agregar_horario
  def agregar_horario

    #aca se llega mediante la accion anterior, enviando el form de nuevo_horario
  end

  #POST /eventos/1/agregar_tipo
  def agregar_tipo
    @evento = Evento.find(params[:id]) #obtener el evento
    @evento.tipos.create(:nombre => params[:tipo])
    #agregarle el tipo
    redirect_to @evento
   
  end



  # GET /eventos/1
  # GET /eventos/1.json
  def show
    ev = @evento
    respond_to do |format|
      format.html
      format.json { 
                    if (params[:appkey].eql? appkey)  #si el appkey es correcto
                          render :json => {:nombre => ev.nombre, :descripcion => ev.descripcion, :horario => ev.horario, :establecimiento_nombre => ev.establecimiento.nombre,
                                    :establecimiento_id => ev.establecimiento.id, :tipos => ev.tipos.map {|tipo| {:nombre => tipo.nombre } },
                                    :imagenes => ev.ImagenEventos.map { |img| { :url => img.foto.url(:small) }  }  } 
                  else
                    render json: {:error => "No autorizado"}
                  end

                                  }  

    end
  end

  # GET /eventos/new
  def new
    if (usuario_signed_in?) #Si hay un usuario logueado, entonces lo toma
      @usuario = current_usuario
      @evento = Evento.new
      @evento.ImagenEventos.build# crea una imagen por default
    else #Si no hay usuario logueado, entonces no lo deja crear evento y lo manda a loguearse.
      redirect_to :controller=>'login', :action=>'login'
    end

  end

  # GET /eventos/1/edit
  def edit
      @usuario = Evento.find(params[:id]).establecimiento.usuario #busca el usuario al que pertenece el evento
      if (current_usuario != @usuario) #si el usuario logueado no es el mismo
        redirect_to :controller=>'login', :action=>'login' #lo envia a login, no lo deja modificarlo
      end
      @tipos = Tipo.all #obtiene la lista de todos los tipos y la pasa al view
      @evento = Evento.find(params[:id])
      @evento.ImagenEventos.build # crea una imagen por si la desea agregar
      # si llega aca, entonces si es el usuario
  end

  # POST /eventos
  # POST /eventos.json
  def create
    if (usuario_signed_in?) #Si hay un usuario logueado, entonces lo toma
      @evento = Evento.new(evento_params)
    else #Si no hay usuario logueado, entonces no lo deja crear evento y lo manda a loguearse.
      redirect_to :controller=>'login', :action=>'login'
    end
    respond_to do |format|
      if @evento.save
        format.html { redirect_to current_usuario, notice: 'Creado con éxito.'}
        format.json { render action: 'show', status: :created, location: @evento }
      else
        format.html { render action: 'new' }
        format.json { render json: @evento.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /eventos/1
  # PATCH/PUT /eventos/1.json
  def update
      @usuario = Evento.find(params[:id]).establecimiento.usuario #busca el usuario al que pertenece el evento
      if (current_usuario != @usuario) #si el usuario logueado no es el mismo
        redirect_to :controller=>'login', :action=>'login' #lo envia a login, no lo deja modificarlo
      end
      respond_to do |format|
      if @evento.update(evento_params)
        format.html { redirect_to current_usuario, notice: 'Actualizado con éxito' }
        format.json { head :no_content }
      else
        format.html { render action: 'edit' }
        format.json { render json: @evento.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /eventos/1
  # DELETE /eventos/1.json
  def destroy
      @usuario = Evento.find(params[:id]).establecimiento.usuario #busca el usuario al que pertenece el evento
      if (current_usuario != @usuario) #si el usuario logueado no es el mismo
        redirect_to :controller=>'login', :action=>'login' #lo envia a login, no lo deja modificarlo
      end
    @evento.destroy
    respond_to do |format|
      format.html { redirect_to current_usuario }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_evento
      @evento = Evento.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def evento_params
      params.require(:evento).permit!
    end
end

class EstablecimientosController < ApplicationController
  before_action :set_establecimiento, only: [:show, :edit, :update, :destroy]

  # GET /establecimientos
  # GET /establecimientos.json
  def index
    redirect_to :controller=>'login', :action=>'login' #lo envia a login, no lo deja modificarlo
  end

  # GET /establecimientos/1
  # GET /establecimientos/1.json
  def show 
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
    @establecimiento = Establecimiento.new(establecimiento_params)
    @establecimiento.usuario_id = current_usuario.id
    respond_to do |format|
      if @establecimiento.save
        format.html { redirect_to @establecimiento, notice: 'Establecimiento was successfully created.' }
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
      @usuario = Establecimiento.find(establecimiento_params[:id]).usuario #busca el usuario al que pertenece el establecimiento
      if (current_usuario != @usuario) #si el usuario logueado no es el mismo
        redirect_to :controller=>'login', :action=>'login' #lo envia a login, no lo deja modificarlo
      end
      #si llega aca es porque si es el dueño del establecimiento
    respond_to do |format|
      if @establecimiento.update(establecimiento_params)
        format.html { redirect_to @establecimiento, notice: 'Establecimiento was successfully updated.' }
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
    @establecimiento.destroy
    respond_to do |format|
      format.html { redirect_to establecimientos_url }
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
      params.require(:establecimiento).permit(:nombre, :direccion, :longitud, :latitud, :descripcion, :usuario_id)
    end
end

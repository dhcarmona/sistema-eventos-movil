class UsuariosController < ApplicationController
  before_action :set_usuario, only: [:show, :edit, :update, :destroy]
	
  #GET /usuarios
  #GET /usuarios.json
  def index
    @usuarios = Usuario.all
  end

  # GET /usuarios/1
  # GET /usuarios/1.json
  def show
      respond_to do |format| #dependiendo del formato del request, el app movil lo pide por JSON.
      format.html { #si es por HTML, es un browser
        @usuario = Usuario.find(params[:id]) #busca el usuario con ese id
        if (current_usuario != @usuario) #si el usuario logueado no es el mismo
            redirect_to :controller=>'login', :action=>'login' #lo manda a loguearse
        end
        @establecimientos = @usuario.establecimientos
      }
      format.json { #si el request es por JSON
        #####  IMPORTANTE -> verificar identidad antes de enviar json.
        render json: @usuario 
      }
      end
  end

  # GET /usuarios/new
  def new
    @usuario = Usuario.new
  end

  # GET /usuarios/1/edit
  def edit
      @usuario = Usuario.find(params[:id]) #busca el usuario con ese id
      if (current_usuario != @usuario) #si el usuario logueado no es el mismo
        redirect_to :controller=>'login', :action=>'login'
      end
  end

  # POST /usuarios
  # POST /usuarios.json
  def create
    @usuario = Usuario.new(usuario_params)

    respond_to do |format|
      if @usuario.save
        format.html { redirect_to @usuario, notice: 'Usuario was successfully created.' }
        format.json { render action: 'show', status: :created, location: @usuario }
      else
        format.html { render action: 'new' }
        format.json { render json: @usuario.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /usuarios/1
  # PATCH/PUT /usuarios/1.json
  def update
    respond_to do |format|
      if @usuario.update(usuario_params)
        format.html { redirect_to @usuario, notice: 'Usuario was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: 'edit' }
        format.json { render json: @usuario.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /usuarios/1
  # DELETE /usuarios/1.json
  def destroy
    @usuario = Usuario.find(params[:id]) #busca el usuario con ese id
      if (current_usuario != @usuario) #si el usuario logueado no es el mismo
        redirect_to :controller=>'login', :action=>'login'
      end
    @usuario.destroy
    respond_to do |format|
      format.html { redirect_to usuarios_url }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_usuario
      @usuario = Usuario.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def usuario_params
      params.require(:usuario).permit(:email, :nombre, :foto, :username, :password, :facebook, :twitter)
    end
end

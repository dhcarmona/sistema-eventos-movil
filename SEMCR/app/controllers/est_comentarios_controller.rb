class EstComentariosController < ApplicationController
  before_action :set_est_comentario, only: [:show, :edit, :update, :destroy]

  # GET /est_comentarios
  # GET /est_comentarios.json
  def index
    @est_comentarios = EstComentario.all
  end

  # GET /est_comentarios/1
  # GET /est_comentarios/1.json
  def show
  end

  # GET /est_comentarios/new
  def new
    @est_comentario = EstComentario.new
  end

  # GET /est_comentarios/1/edit
  def edit
  end

  # POST /est_comentarios
  # POST /est_comentarios.json
  def create
    @est_comentario = EstComentario.new(est_comentario_params)

    respond_to do |format|
      if @est_comentario.save
        format.html { redirect_to @est_comentario, notice: 'Est comentario was successfully created.' }
        format.json { render action: 'show', status: :created, location: @est_comentario }
      else
        format.html { render action: 'new' }
        format.json { render json: @est_comentario.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /est_comentarios/1
  # PATCH/PUT /est_comentarios/1.json
  def update
    respond_to do |format|
      if @est_comentario.update(est_comentario_params)
        format.html { redirect_to @est_comentario, notice: 'Est comentario was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: 'edit' }
        format.json { render json: @est_comentario.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /est_comentarios/1
  # DELETE /est_comentarios/1.json
  def destroy
    @est_comentario.destroy
    respond_to do |format|
      format.html { redirect_to est_comentarios_url }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_est_comentario
      @est_comentario = EstComentario.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def est_comentario_params
      params.require(:est_comentario).permit(:descripcion, :usuario_id, :establecimiento_id)
    end
end

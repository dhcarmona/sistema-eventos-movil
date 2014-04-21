class EvComentariosController < ApplicationController
  before_action :set_ev_comentario, only: [:show, :edit, :update, :destroy]

  # GET /ev_comentarios
  # GET /ev_comentarios.json
  def index
    @ev_comentarios = EvComentario.all
  end

  # GET /ev_comentarios/1
  # GET /ev_comentarios/1.json
  def show
  end

  # GET /ev_comentarios/new
  def new
    @ev_comentario = EvComentario.new
  end

  # GET /ev_comentarios/1/edit
  def edit
  end

  # POST /ev_comentarios
  # POST /ev_comentarios.json
  def create
    @ev_comentario = EvComentario.new(ev_comentario_params)

    respond_to do |format|
      if @ev_comentario.save
        format.html { redirect_to @ev_comentario, notice: 'Ev comentario was successfully created.' }
        format.json { render action: 'show', status: :created, location: @ev_comentario }
      else
        format.html { render action: 'new' }
        format.json { render json: @ev_comentario.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /ev_comentarios/1
  # PATCH/PUT /ev_comentarios/1.json
  def update
    respond_to do |format|
      if @ev_comentario.update(ev_comentario_params)
        format.html { redirect_to @ev_comentario, notice: 'Ev comentario was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: 'edit' }
        format.json { render json: @ev_comentario.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /ev_comentarios/1
  # DELETE /ev_comentarios/1.json
  def destroy
    @ev_comentario.destroy
    respond_to do |format|
      format.html { redirect_to ev_comentarios_url }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_ev_comentario
      @ev_comentario = EvComentario.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def ev_comentario_params
      params.require(:ev_comentario).permit(:descripcion, :usuario_id, :evento_id)
    end
end

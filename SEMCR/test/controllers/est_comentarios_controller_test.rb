require 'test_helper'

class EstComentariosControllerTest < ActionController::TestCase
  setup do
    @est_comentario = est_comentarios(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:est_comentarios)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create est_comentario" do
    assert_difference('EstComentario.count') do
      post :create, est_comentario: { descripcion: @est_comentario.descripcion, establecimiento_id: @est_comentario.establecimiento_id, usuario_id: @est_comentario.usuario_id }
    end

    assert_redirected_to est_comentario_path(assigns(:est_comentario))
  end

  test "should show est_comentario" do
    get :show, id: @est_comentario
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @est_comentario
    assert_response :success
  end

  test "should update est_comentario" do
    patch :update, id: @est_comentario, est_comentario: { descripcion: @est_comentario.descripcion, establecimiento_id: @est_comentario.establecimiento_id, usuario_id: @est_comentario.usuario_id }
    assert_redirected_to est_comentario_path(assigns(:est_comentario))
  end

  test "should destroy est_comentario" do
    assert_difference('EstComentario.count', -1) do
      delete :destroy, id: @est_comentario
    end

    assert_redirected_to est_comentarios_path
  end
end

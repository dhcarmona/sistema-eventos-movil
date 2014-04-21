require 'test_helper'

class EvComentariosControllerTest < ActionController::TestCase
  setup do
    @ev_comentario = ev_comentarios(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:ev_comentarios)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create ev_comentario" do
    assert_difference('EvComentario.count') do
      post :create, ev_comentario: { descripcion: @ev_comentario.descripcion, evento_id: @ev_comentario.evento_id, usuario_id: @ev_comentario.usuario_id }
    end

    assert_redirected_to ev_comentario_path(assigns(:ev_comentario))
  end

  test "should show ev_comentario" do
    get :show, id: @ev_comentario
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @ev_comentario
    assert_response :success
  end

  test "should update ev_comentario" do
    patch :update, id: @ev_comentario, ev_comentario: { descripcion: @ev_comentario.descripcion, evento_id: @ev_comentario.evento_id, usuario_id: @ev_comentario.usuario_id }
    assert_redirected_to ev_comentario_path(assigns(:ev_comentario))
  end

  test "should destroy ev_comentario" do
    assert_difference('EvComentario.count', -1) do
      delete :destroy, id: @ev_comentario
    end

    assert_redirected_to ev_comentarios_path
  end
end

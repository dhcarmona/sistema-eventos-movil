require 'test_helper'

class EstablecimientosControllerTest < ActionController::TestCase
  setup do
    @establecimiento = establecimientos(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:establecimientos)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create establecimiento" do
    assert_difference('Establecimiento.count') do
      post :create, establecimiento: { descripcion: @establecimiento.descripcion, direccion: @establecimiento.direccion, latitud: @establecimiento.latitud, longitud: @establecimiento.longitud, nombre: @establecimiento.nombre, usuario_id: @establecimiento.usuario_id }
    end

    assert_redirected_to establecimiento_path(assigns(:establecimiento))
  end

  test "should show establecimiento" do
    get :show, id: @establecimiento
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @establecimiento
    assert_response :success
  end

  test "should update establecimiento" do
    patch :update, id: @establecimiento, establecimiento: { descripcion: @establecimiento.descripcion, direccion: @establecimiento.direccion, latitud: @establecimiento.latitud, longitud: @establecimiento.longitud, nombre: @establecimiento.nombre, usuario_id: @establecimiento.usuario_id }
    assert_redirected_to establecimiento_path(assigns(:establecimiento))
  end

  test "should destroy establecimiento" do
    assert_difference('Establecimiento.count', -1) do
      delete :destroy, id: @establecimiento
    end

    assert_redirected_to establecimientos_path
  end
end

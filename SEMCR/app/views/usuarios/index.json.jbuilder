json.array!(@usuarios) do |usuario|
  json.extract! usuario, :id, :nombre, :foto, :contrasena, :username, :facebook, :twitter
  json.url usuario_url(usuario, format: :json)
end

json.array!(@usuarios) do |usuario|
  json.extract! usuario, :id, :nombre, :foto, :username, :password_digest, :facebook, :twitter
  json.url usuario_url(usuario, format: :json)
end

json.array!(@establecimientos) do |establecimiento|
  json.extract! establecimiento, :id, :nombre, :direccion, :longitud, :latitud, :descripcion, :usuario_id
  json.url establecimiento_url(establecimiento, format: :json)
end

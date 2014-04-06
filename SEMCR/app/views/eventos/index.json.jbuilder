json.array!(@eventos) do |evento|
  json.extract! evento, :id, :nombre, :descripcion, :establecimiento_id
  json.url evento_url(evento, format: :json)
end

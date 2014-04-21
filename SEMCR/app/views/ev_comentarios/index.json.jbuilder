json.array!(@ev_comentarios) do |ev_comentario|
  json.extract! ev_comentario, :id, :descripcion, :usuario_id, :evento_id
  json.url ev_comentario_url(ev_comentario, format: :json)
end

json.array!(@est_comentarios) do |est_comentario|
  json.extract! est_comentario, :id, :descripcion, :usuario_id, :establecimiento_id
  json.url est_comentario_url(est_comentario, format: :json)
end

class EstComentario < ActiveRecord::Base
	attr_accessible :descripcion, :establecimiento_id, :usuario_id
	belongs_to :usuario
	belongs_to :establecimiento
end

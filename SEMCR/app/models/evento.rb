class Evento < ActiveRecord::Base
	attr_accessible :nombre, :descripcion, :establecimiento_id
	belongs_to :establecimiento
end

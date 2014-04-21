class Evento < ActiveRecord::Base
	attr_accessible :nombre, :descripcion, :establecimiento_id, :horario, :ImagenEventos_attributes
	has_many :ImagenEventos, :dependent => :destroy
	accepts_nested_attributes_for :ImagenEventos
	belongs_to :establecimiento
	has_many :EvComentarios, :dependent => :destroy
	has_many :tipos, :dependent => :destroy

end

class Establecimiento < ActiveRecord::Base
 attr_accessible :id, :nombre, :direccion, :longitud, :latitud, :descripcion, :usuario_id
 has_many :eventos, dependent: :destroy
 belongs_to :usuario
end

class Establecimiento < ActiveRecord::Base
 attr_accessible :id, :nombre, :direccion, :longitud, :latitud, :descripcion, :usuario_id
end

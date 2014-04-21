class Establecimiento < ActiveRecord::Base
 attr_accessible :id, :nombre, :direccion, :longitud, :latitud, :descripcion, :usuario_id, :foto
 has_many :eventos, :dependent => :destroy
 has_many :EstComentarios
 belongs_to :usuario

 has_attached_file :foto, :styles => {:small => "50x50", :medium => "200x200"}
end

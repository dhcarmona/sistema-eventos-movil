class ImagenEvento < ActiveRecord::Base
	attr_accessible :foto, :evento_id, :ImagenEvento_id
	belongs_to :evento
	has_attached_file :foto, :styles => {:small => "150x150", :medium => "400x400"}
end

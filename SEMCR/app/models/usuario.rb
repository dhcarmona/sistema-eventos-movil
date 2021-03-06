class Usuario < ActiveRecord::Base
  # Include default devise modules. Others available are:
  # :confirmable, :lockable, :timeoutable and :omniauthable
  devise :database_authenticatable, :registerable,
         :recoverable, :rememberable, :trackable, :validatable

 attr_accessible :nombre, :email, :password, :id, :username, :foto, :facebook

 #OJO -> cambiar si se cambia de ambiente 
 Paperclip.options[:command_path] = 'C:\Program Files (x86)\ImageMagick-6.5.6-Q8'
 
 has_many :establecimientos, :dependent => :destroy
 has_many :EstComentarios, :dependent => :destroy
 has_many :EvComentarios, :dependent => :destroy

 has_attached_file :foto, :styles => {:small => "150x150", :medium => "300x300"}, :default_url => "/images/default/missing.PNG"
 validates_attachment :foto, :presence => true
end

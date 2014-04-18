class Usuario < ActiveRecord::Base
  # Include default devise modules. Others available are:
  # :confirmable, :lockable, :timeoutable and :omniauthable
  devise :database_authenticatable, :registerable,
         :recoverable, :rememberable, :trackable, :validatable

 attr_accessible :nombre, :email, :password, :id, :username, :foto, :facebook, :twitter

 #OJO -> cambiar si se cambia de ambiente 
 Paperclip.options[:command_path] = 'C:\Program Files (x86)\ImageMagick-6.5.6-Q8'
 
 has_many :establecimientos

 has_attached_file :foto, :styles => {:small => "50x50", :medium => "200x200"}
end

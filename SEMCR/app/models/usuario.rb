class Usuario < ActiveRecord::Base
 attr_accessible :id, :username, :password_digest, :nombre, :foto, :facebook, :twitter
 has_many :establecimientos
end

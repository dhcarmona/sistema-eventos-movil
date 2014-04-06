class Usuario < ActiveRecord::Base
 attr_accessible :id, :username, :password_digest, :nombre, :foto, :facebook, :twitter
end

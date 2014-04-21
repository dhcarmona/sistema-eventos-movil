class Tipo < ActiveRecord::Base
	attr_accessible :nombre
	belongs_to :evento
end

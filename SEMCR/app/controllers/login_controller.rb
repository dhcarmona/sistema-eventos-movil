class LoginController < ApplicationController
  def login
	if !usuario_signed_in? #si no hay un usuario logueado
			if (params.has_key?(:email) && params.has_key?(:password))	# si no hay parametros, no hace nada
				#si hay parametros, entonces busca el usuario por el correo
				@usuario = Usuario.find_by(:email => params[:email])
				
				if !(@usuario.nil?) #si el usuario existe
					if @usuario.valid_password?(params[:password]) #lo verifica con el hash
						sign_in(:usuario, @usuario) #lo loguea si es correcto
						redirect_to(current_usuario) #lo envia a su perfil
					else  #si la contraseña no corresponde
						flash.now["alert alert-danger"] = "Los datos de inicio no son correctos."
					end
				else #el usuario no existe
					flash.now["alert alert-danger"] = "El usuario especificado no esta registrado."	
				end
			end
	else # si yá está logueado
		redirect_to(current_usuario) #lo envia a su perfil
	end


   end

end

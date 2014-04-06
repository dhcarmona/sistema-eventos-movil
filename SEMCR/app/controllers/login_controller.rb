class LoginController < ApplicationController
  def login
	@user_name = params[:username]
	@password = params[:password]
	@usuario = Usuario.find_by username: @user_name
	if !(@usuario.nil?)
		if (@password == @usuario.password_digest)
			redirect_to @usuario
		end
	end	
  end
end

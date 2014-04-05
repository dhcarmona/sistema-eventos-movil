class LoginController < ApplicationController
  def login
	@username = params[:username]
	@password = params[:password]
  end
end

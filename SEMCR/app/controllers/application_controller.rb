class ApplicationController < ActionController::Base
  # Prevent CSRF attacks by raising an exception.
  # For APIs, you may want to use :null_session instead.
  protect_from_forgery with: :exception
  before_filter :configure_permitted_parameters, if: :devise_controller?
  before_filter :set_locale



# lo siguiente es para que los strong params puedan ser modificados por el controlador de registration de Devise, es como el 
# def_params de UsuarioController pero para Devise.

#IMPORTANTE -> siempre que una accion de algun controlador de Devise tenga que modificar algun atributo de User, entonces hay que permitirlo aca,
# no importa si el atributo va a la base de datos o no.

def configure_permitted_parameters
  devise_parameter_sanitizer.for(:sign_up) do |u|
	u.permit :username, :email, :password, :password_confirmation, :foto, :facebook, :nombre, :twitter
	end
  devise_parameter_sanitizer.for(:account_update) do |u|
	u.permit :username, :email, :password, :password_confirmation, :foto, :facebook, :nombre, :twitter, :current_password
	end
end

private

def set_locale
  I18n.locale = params[:locale] || "es"
end

def appkey
  return "1405ee0b5234c53980d46d493ae2a0cb"
end

end

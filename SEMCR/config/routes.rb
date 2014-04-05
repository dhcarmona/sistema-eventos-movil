SEMCR::Application.routes.draw do
  resources :usuarios
  post "login/login"
  get "usuarios/new"
  get "usuarios/show"
  get "login/login"

end

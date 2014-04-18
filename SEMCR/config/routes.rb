SEMCR::Application.routes.draw do
  devise_for :usuarios
  root 'login#login'
  resources :eventos

  resources :establecimientos

  resources :usuarios
  post "login/login"
  get "usuarios/new"
  get "usuarios/show"
  get "login/login"

end

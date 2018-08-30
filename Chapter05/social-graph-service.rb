require 'sinatra'
require 'json'

get '/friendships/:username' do
  content_type :json
  {
    'username': params[:username],
    'friendships': [
      'pichat:users:johndoe',
      'pichat:users:janesmith',
      'pichat:users:anotheruser'
    ]
  }.to_json
end

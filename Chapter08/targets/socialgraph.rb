require 'sinatra'

get '/friendships/:user' do
    content_type :json
    {
        username: "user:32134",
        friendships: [
            "user:12345"
        ]
    }.to_json
end

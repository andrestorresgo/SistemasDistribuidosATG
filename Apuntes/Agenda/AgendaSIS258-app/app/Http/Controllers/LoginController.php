<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\User;
use Illuminate\Support\Facades\Hash;
use Firebase\JWT\JWT;

class LoginController extends Controller
{
    public function login(Request $request){
        $input = $request->all();
        $usuario = User::where('email', $input['email'])->first();
        if($usuario == null){
            return response()->json(['message' => 'Usuario no encontrado'], 404);
        }
        if(!Hash::check($input['password'], $usuario->password)){
            $key = 'algo';
            $algorithm = 'RS256';
            $time = time();
            $token = array(
                'iat' => $time,
                'exp' => $time + 3600,
                'data' => [
                    'user' => $usuario
                ]
            );
        }
        return $usuario;
    }
}

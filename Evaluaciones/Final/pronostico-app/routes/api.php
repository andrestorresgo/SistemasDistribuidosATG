<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ClimaController;
use App\Http\Controllers\AuthController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

Route::middleware('auth:api')->get('/clima', 'ClimaController@index');
Route::middleware('auth:api')->post('/clima', 'ClimaController@store');

Route::group([

    'middleware' => 'api',
    'prefix' => 'auth'

], function ($router) {

    Route::post('login', 'AuthController@login');
    Route::post('register', 'AuthController@register');
    Route::post('logout', 'AuthController@logout');
    Route::post('refresh', 'AuthController@refresh');
    Route::post('me', 'AuthController@me');

});

Route::middleware('auth:api')->get('/clima', 'ClimaController@index');
Route::middleware('auth:api')->post('/clima', 'ClimaController@store');
Route::middleware('auth:api')->get('/clima/{id}', 'ClimaController@show');
Route::middleware('auth:api')->put('/clima/{id}', 'ClimaController@update');
Route::middleware('auth:api')->delete('/clima/{id}', 'ClimaController@destroy');

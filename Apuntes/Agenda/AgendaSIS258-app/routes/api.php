<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use Spatie\FlareClient\Api;
use App\Http\Controllers\AgendaController;
use App\Http\Controllers\PaisController;
use App\Http\Controllers\LoginController;

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

Route::apiResource('agenda', AgendaController::class);

Route::apiResource('pais', PaisController::class);

Route::post('/login', [LoginController::class, 'login']);	

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

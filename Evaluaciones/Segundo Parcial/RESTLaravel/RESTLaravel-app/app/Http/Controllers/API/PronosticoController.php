<?php

namespace App\Http\Controllers\API;

use App\Http\Controllers\Controller;
use App\Models\Pronostico;
use Illuminate\Http\Request;

class PronosticoController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        return Pronostico::all();
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        return Pronostico::create($request->all());
    }

    /**
     * Display the specified resource.
     */
    public function show(Pronostico $pronostico)
    {
        return $pronostico;
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Pronostico $pronostico)
    {
        $pronostico->update($request->all());
        return $pronostico;
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Pronostico $pronostico)
    {
        $pronostico->delete();
        return response()->json(null, 204);
    }
}

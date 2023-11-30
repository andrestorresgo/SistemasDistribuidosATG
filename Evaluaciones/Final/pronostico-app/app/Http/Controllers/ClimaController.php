<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Clima;

class ClimaController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        return Clima::all();
    }
    public function store(Request $request)
    {
        $weather = Clima::create($request->all());
        return response()->json($weather, 201);
    }

    public function show($id)
    {
        return Clima::findOrFail($id);
    }

    public function update(Request $request, $id)
    {
        $weather = Clima::findOrFail($id);
        $weather->update($request->all());

        return response()->json($weather, 200);
    }
    
    public function destroy($id)
    {
        Clima::destroy($id);

        return response()->json(null, 204);
    }
}

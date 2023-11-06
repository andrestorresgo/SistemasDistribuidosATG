<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Pais;

class PaisController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        response()->json([
            'mensaje' => 'Listado de paises',
            'data' => Pais::all(),
            
        ]);
        return Pais::all();
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $input = $request->all();
        $pais = Pais::create($input);
        return $pais;
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $pais = Pais::find($id);
        if (!$pais === null) {
            return $pais;
        } else {
            return response()->json(['message' => 'Not found'], 404);
        }
        return $pais;
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $input = $request->all();
        $pais = Pais::find($id);
        if (!$pais === null) {
            return response()->json(['message' => 'Not found'], 404);
        }
        $pais->update($input);
        return $pais;
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $pais = Pais::find($id);
        if (!$pais === null) {
            return response()->json(['message' => 'Not found'], 404);
        }
        $pais->delete();
        return response()->json(null, 204);
    }
}

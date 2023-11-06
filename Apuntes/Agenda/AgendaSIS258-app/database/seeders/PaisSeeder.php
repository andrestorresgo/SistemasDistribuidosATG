<?php

namespace Database\Seeders;

use App\Models\Pais;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class PaisSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        Pais::create(['nombre' => 'Bolivia','codigo' => 'BO']);
        Pais::create(['nombre' => 'Argentina','codigo' => 'AR']);
        Pais::create(['nombre' => 'Peru','codigo' => 'PE']);
        Pais::create(['nombre' => 'Paraguay','codigo' => 'PY']);
    }
}

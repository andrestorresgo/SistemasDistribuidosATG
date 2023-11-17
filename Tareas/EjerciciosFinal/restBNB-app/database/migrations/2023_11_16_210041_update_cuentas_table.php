<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::table('cuentas', function (Blueprint $table) {
            $table->string('numero_cuenta', 255);
            $table->string('moneda', 255);
            //$table->double('saldo', 8, 2);
            $table->bigInteger('codigo_cliente');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('cuentas', function (Blueprint $table) {
            $table->dropColumn(['numero_cuenta', 'moneda', 'codigo_cliente']);
        });
    }
};

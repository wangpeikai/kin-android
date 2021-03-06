// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten
package org.kin.stellarfork.xdr

import java.io.IOException

// === xdr source ============================================================
//  union InflationResult switch (InflationResultCode code)
//  {
//  case INFLATION_SUCCESS:
//      InflationPayout payouts<>;
//  default:
//      void;
//  };
//  ===========================================================================
class InflationResult {
    var discriminant: InflationResultCode? = null
    var payouts: Array<InflationPayout?> = arrayOfNulls(0)

    companion object {
        @JvmStatic
        @Throws(IOException::class)
        fun encode(
            stream: XdrDataOutputStream,
            encodedInflationResult: InflationResult
        ) {
            stream.writeInt(encodedInflationResult.discriminant!!.value)
            when (encodedInflationResult.discriminant) {
                InflationResultCode.INFLATION_SUCCESS -> {
                    val payoutssize = encodedInflationResult.payouts.size
                    stream.writeInt(payoutssize)
                    var i = 0
                    while (i < payoutssize) {
                        InflationPayout.encode(stream, encodedInflationResult.payouts[i]!!)
                        i++
                    }
                }
                else -> {
                }
            }
        }

        @JvmStatic
        @Throws(IOException::class)
        fun decode(stream: XdrDataInputStream): InflationResult {
            val decodedInflationResult = InflationResult()
            val discriminant = InflationResultCode.decode(stream)
            decodedInflationResult.discriminant = discriminant
            when (decodedInflationResult.discriminant) {
                InflationResultCode.INFLATION_SUCCESS -> {
                    val payoutssize = stream.readInt()
                    decodedInflationResult.payouts = arrayOfNulls(payoutssize)
                    var i = 0
                    while (i < payoutssize) {
                        decodedInflationResult.payouts[i] = InflationPayout.decode(stream)
                        i++
                    }
                }
                else -> {
                }
            }
            return decodedInflationResult
        }
    }
}

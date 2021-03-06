// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten
package org.kin.stellarfork.xdr

import java.io.IOException

// === xdr source ============================================================
//  struct Price
//  {
//      int32 n; // numerator
//      int32 d; // denominator
//  };
//  ===========================================================================
class Price {
    var n: Int32? = null
    var d: Int32? = null

    companion object {
        @JvmStatic
        @Throws(IOException::class)
        fun encode(
            stream: XdrDataOutputStream,
            encodedPrice: Price
        ) {
            Int32.encode(stream, encodedPrice.n!!)
            Int32.encode(stream, encodedPrice.d!!)
        }

        @JvmStatic
        @Throws(IOException::class)
        fun decode(stream: XdrDataInputStream): Price {
            val decodedPrice = Price()
            decodedPrice.n = Int32.decode(stream)
            decodedPrice.d = Int32.decode(stream)
            return decodedPrice
        }
    }
}

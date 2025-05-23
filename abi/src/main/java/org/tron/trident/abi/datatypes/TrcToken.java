/*
 * Copyright 2019 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.tron.trident.abi.datatypes;

import java.math.BigInteger;

/**
 * Unsigned integer type.
 */
public class TrcToken extends IntType {

  public static final String TYPE_NAME = "trcToken";
  public static final Uint DEFAULT = new Uint(BigInteger.ZERO);

  protected TrcToken(int bitSize, BigInteger value) {
    super(TYPE_NAME, bitSize, value);
  }

  public TrcToken(int value) {
    this(BigInteger.valueOf(value));
  }

  public TrcToken(BigInteger value) {
    // "int" values should be declared as int256 in computing function selectors
    this(MAX_BIT_LENGTH, value);
  }

  @Override
  protected boolean valid() {
    return super.valid() && 0 <= value.signum();
  }
}

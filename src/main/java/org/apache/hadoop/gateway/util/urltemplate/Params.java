/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.gateway.util.urltemplate;

import java.util.*;

public class Params implements Resolver {

  private Map<String,List<String>> map = new HashMap<String,List<String>>();

//  public void addName( String name ) {
//    List<String> values = getValues( name );
//    if( values == null ) {
//      values = new ArrayList<String>();
//      map.put( name, values );
//    }
//  }

  public Set<String> getNames() {
    return map.keySet();
  }

  private List<String> getOrAddValues( String name ) {
    List<String> values = getValues( name );
    if( values == null ) {
      values = new ArrayList<String>( 1 );
      map.put( name, values );
    }
    return values;
  }

  public void addValue( String name, String value ) {
    List<String> values = getOrAddValues( name );
    values.add( value );
  }

  public void insertValue( String name, String value ) {
    List<String> values = getOrAddValues( name );
    values.add( 0, value );
  }

  public List<String> getValues( String name ) {
    return map.get( name );
  }

}

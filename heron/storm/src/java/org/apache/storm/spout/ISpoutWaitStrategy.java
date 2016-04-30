// Copyright 2016 Twitter. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.apache.storm.spout;

import java.util.Map;

/**
 * The strategy a spout needs to use when its waiting. Waiting is
 * triggered in one of two conditions:
 * <p>
 * 1. nextTuple emits no tuples
 * 2. The spout has hit maxSpoutPending and can't emit any more tuples
 * <p>
 * The default strategy sleeps for one millisecond.
 */
public interface ISpoutWaitStrategy {
  void prepare(Map<String, Object> conf);

  void emptyEmit(long streak);
}

/*
 * Copyright 2012-2015 Ye Ding
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.polling.core.maker;

import org.polling.core.AttemptMaker;
import org.polling.core.AttemptResult;
import org.polling.core.AttemptResults;

/**
 * Created by dingye on 17/12/31.
 */
public class TryFixedTimesAttemptMaker implements AttemptMaker<Void> {
    private final int limit;
    private int triedNum;

    public TryFixedTimesAttemptMaker(int limit) {
        this.limit = limit;
        this.triedNum = 0;
    }

    @Override
    public AttemptResult<Void> process() {
        if (triedNum++ < limit) {
            return AttemptResults.justContinue();
        } else {
            return AttemptResults.justFinish();
        }
    }
}
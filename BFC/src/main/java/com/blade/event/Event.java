/**
 * Copyright (c) 2017, biezhi 王爵 (biezhi.me@gmail.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blade.event;

import com.blade.Blade;

public class Event {

    public EventType eventType;
    public Blade     blade;

    public Event(EventType eventType) {
        this.eventType = eventType;
    }

    public Event(EventType eventType, Blade blade) {
        this.eventType = eventType;
        this.blade = blade;
    }

}
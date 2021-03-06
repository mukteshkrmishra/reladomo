/*
 Copyright 2016 Goldman Sachs.
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */

package com.gs.fw.common.mithra.finder.time;

import com.gs.fw.common.mithra.attribute.TimeAttribute;
import com.gs.fw.common.mithra.finder.NonPrimitiveNotEqOperation;
import com.gs.fw.common.mithra.util.Time;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class TimeNotEqOperation extends NonPrimitiveNotEqOperation implements Externalizable
{
    public TimeNotEqOperation(TimeAttribute attribute, Time parameter)
    {
        super(attribute, parameter);
    }

    public TimeNotEqOperation()
    {
        // for externalizable
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeObject(this.getAttribute());
        Time.writeToStream(out, (Time) this.getParameterAsObject());
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        TimeAttribute attribute = (TimeAttribute) in.readObject();
        this.setAttribute(attribute);
        this.setParameter(Time.readFromStream(in));
    }
}

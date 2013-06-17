/**
 * Copyright (c) 2013, Groupon, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * Neither the name of GROUPON nor the names of its contributors may be
 * used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 * Created with IntelliJ IDEA.
 * User: Dima Kovalenko (@dimacus) && Darko Marinov
 * Date: 5/10/13
 * Time: 4:06 PM
 */

package com.groupon;


import java.util.HashMap;
import java.util.Map;

public class Netstat extends ExecuteOSTask {

  @Override
  public String getEndpoint() {
    return "/netstat";
  }

  @Override
  public String getDescription() {
    return "Returns application information for a given port";
  }

  @Override
  public Map getResponseDescription() {
    Map response = new HashMap();
    response.put("exit_code",
                 "Exit code received from the operating system upon execution of the task");
    response.put("standard_out", "All of the StandardOut received from the system");
    response.put("standard_error", "All of the StandardError received from the system");
    return response;
  }


  @Override
  public Map getAcceptedParams() {
    Map<String, String> params = new HashMap();
    params.put("port", "If port provided, only information on this port will be returned");
    return params;
  }

  @Override
  public String execute(Map<String, String> parameter) {
    if (parameter.isEmpty() || !parameter.containsKey("port")) {
      return execute();
    } else {
      return execute(parameter.get("port").toString());
    }
  }

  @Override
  public String execute(String port) {
    return PortChecker.getPortInfo(port);
  }

}
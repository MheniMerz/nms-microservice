/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


/**
 A service interface managing products.
 <p>
 This service is an event bus service (aka. service proxy)
 </p>

 @class
*/
export default class AuthenticationService {

  constructor (eb: any, address: string);

  initializePersistence(resultHandler: (err: any, result: any) => any) : void;

  saveUser(user: any, resultHandler: (err: any, result: any) => any) : void;

  retrieveUser(username: string, resultHandler: (err: any, result: any) => any) : void;

  retrieveAllUsers(resultHandler: (err: any, result: Array<any>) => any) : void;

  retrieveUsersByRole(role: string, resultHandler: (err: any, result: Array<any>) => any) : void;

  removeUser(username: string, resultHandler: (err: any, result: any) => any) : void;

  authenticateUser(username: string, password: string, resultHandler: (err: any, result: any) => any) : void;

  saveAgent(agent: any, resultHandler: (err: any, result: any) => any) : void;

  retrieveAgent(username: string, resultHandler: (err: any, result: any) => any) : void;

  retrieveAllAgents(resultHandler: (err: any, result: Array<any>) => any) : void;

  removeAgent(username: string, resultHandler: (err: any, result: any) => any) : void;

  authenticateAgent(username: string, password: string, resultHandler: (err: any, result: any) => any) : void;
}
package za.co.absa.spline.producer.model

import java.util.UUID

case class ExecutionPlan(
  id: UUID = UUID.randomUUID(),
  operations: Operations,
  systemInfo: SystemInfo,
  agentInfo: Option[AgentInfo] = None,
  extraInfo: Map[String, Any] = Map.empty
)

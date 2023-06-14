resource "kubernetes_deployment" "zookeeper_deployment" {
  metadata {
    name = "zookeeper-deployment"
    labels = {
      app = "zookeeper"
    }
  }

  spec {
    replicas = 1

    selector {
      match_labels = {
        app = "zookeeper"
      }
    }

    template {
      metadata {
        labels = {
          app = "zookeeper"
        }
      }

      spec {
        container {
          name  = "zookeeper"
          image = "confluentinc/cp-zookeeper:7.0.1"

          port {
            container_port = 2181
          }

          env {
            name  = "ZOOKEEPER_CLIENT_PORT"
            value = "2181"
          }

          env {
            name  = "ZOOKEEPER_TICK_TIME"
            value = "2000"
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "zookeeper_service" {
  metadata {
    name = "zookeeper-service"
  }

  spec {
    selector = {
      app = "zookeeper"
    }

    port {
      protocol    = "TCP"
      port        = 2181
      target_port = 2181
    }
  }
}

resource "kubernetes_deployment" "kafka_deployment" {
  metadata {
    name = "kafka-deployment"
    labels = {
      app = "kafka"
    }
  }

  spec {
    replicas = 1

    selector {
      match_labels = {
        app = "kafka"
      }
    }

    template {
      metadata {
        labels = {
          app = "kafka"
        }
      }

      spec {
        container {
          name  = "broker"
          image = "confluentinc/cp-kafka:7.0.1"

          port {
            container_port = 9092
          }

          env {
            name  = "KAFKA_BROKER_ID"
            value = "1"
          }

          env {
            name  = "KAFKA_ZOOKEEPER_CONNECT"
            value = "zookeeper-service:2181"
          }

          env {
            name  = "KAFKA_LISTENER_SECURITY_PROTOCOL_MAP"
            value = "PLAINTEXT:PLAINTEXT,PLAINTEXT_INTERNAL:PLAINTEXT"
          }

          env {
            name  = "KAFKA_ADVERTISED_LISTENERS"
            value = "PLAINTEXT://:29092,PLAINTEXT_INTERNAL://kafka-service:9092"
          }

          env {
            name  = "KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR"
            value = "1"
          }

          env {
            name  = "KAFKA_TRANSACTION_STATE_LOG_MIN_ISR"
            value = "1"
          }

          env {
            name  = "KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR"
            value = "1"
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "kafka_service" {
  metadata {
    name = "kafka-service"
  }

  spec {
    selector = {
      app = "kafka"
    }

    port {
      protocol    = "TCP"
      port        = 9092
      target_port = 9092
    }
  }
}

resource "kubernetes_deployment" "email_service_worker_deployment" {
  metadata {
    name = "email-service-worker-deployment"
    labels = {
      app = "email-service-worker"
    }
  }

  spec {
    replicas = 1

    selector {
      match_labels = {
        app = "email-service-worker"
      }
    }

    template {
      metadata {
        labels = {
          app = "email-service-worker"
        }
      }

      spec {
        container {
          name  = "email-service-worker"
          image = "wojdzie/email-service-worker:1.0.8"

          port {
            container_port = 8090
          }

          env {
            name  = "KAFKA_BOOSTRAP_SERVERS"
            value = "kafka-service:9092"
          }
        }
      }
    }
  }
}

resource "kubernetes_deployment" "new_account_signup_service_deployment" {
  metadata {
    name = "new-account-signup-service-deployment"
    labels = {
      app = "new-account-signup-service"
    }
  }

  spec {
    replicas = 1

    selector {
      match_labels = {
        app = "new-account-signup-service"
      }
    }

    template {
      metadata {
        labels = {
          app = "new-account-signup-service"
        }
      }

      spec {
        container {
          name  = "new-account-signup-service"
          image = "wojdzie/new-account-signup-service:1.0.7"

          port {
            container_port = 8091
          }

          env {
            name  = "KAFKA_BOOSTRAP_SERVERS"
            value = "kafka-service:9092"
          }
        }
      }
    }
  }
}

resource "kubernetes_deployment" "password_reset_service_deployment" {
  metadata {
    name = "password-reset-service-deployment"
    labels = {
      app = "password-reset-service"
    }
  }

  spec {
    replicas = 1

    selector {
      match_labels = {
        app = "password-reset-service"
      }
    }

    template {
      metadata {
        labels = {
          app = "password-reset-service"
        }
      }

      spec {
        container {
          name  = "password-reset-service"
          image = "wojdzie/password-reset-service:1.0.7"

          port {
            container_port = 8092
          }

          env {
            name  = "KAFKA_BOOSTRAP_SERVERS"
            value = "kafka-service:9092"
          }
        }
      }
    }
  }
}
